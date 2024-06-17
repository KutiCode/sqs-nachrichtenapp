import React, { useState } from 'react';

function SearchBar({ placeholder, onSearchResults }) {
    const [searchQuery, setSearchQuery] = useState('');

    const handleInputChange = (event) => {
        setSearchQuery(event.target.value);
    };

    const handleButtonClick = () => {
        const encodedQuery = encodeURIComponent(searchQuery);
        fetch(`http://localhost:8080/news/search/${encodedQuery}`)
            .then(response => response.json())
            .then(data => {
                if (data && data.articles) {
                    onSearchResults(data.articles);
                } else {
                    onSearchResults([]);
                }
            })
            .catch(error => {
                console.error(error);
                onSearchResults([]);
            });
    };

    return (
        <div className="search-bar">
            <input type="text" placeholder={placeholder} value={searchQuery} onChange={handleInputChange} />
            <button onClick={handleButtonClick}>Go!</button>
        </div>
    );
}

export default SearchBar;
