import React from 'react';

function SearchBar({ placeholder }) {
    return (
        <div className="search-bar">
            <input type="text" placeholder={placeholder} />
            <button>Go!</button>
        </div>
    );
}

export default SearchBar;
