import React, { useState } from 'react';

function Dropdown({ label, setTrendingTopics }) {
    const [selectedCountry, setSelectedCountry] = useState('de');

    const handleSelectChange = (event) => {
        setSelectedCountry(event.target.value);
    };

    const handleButtonClick = () => {
        const currentDate = new Date().toISOString().split('T')[0];
        fetch(`http://localhost:8080/news/${selectedCountry}/${currentDate}`)
            .then(response => response.json())
            .then(data => {
                if (data && data.articles) {
                    setTrendingTopics(data.articles);
                } else {
                    setTrendingTopics([]);
                }
            })
            .catch(error => {
                console.error(error);
                setTrendingTopics([]);
            });
    };

    return (
        <div className="dropdown">
            <label>{label}</label>
            <select onChange={handleSelectChange}>
                <option value="de">Deutschland</option>
                <option value="us">USA</option>
                <option value="fr">Frankreich</option>
                <option value="it">Italien</option>
                <option value="es">Spanien</option>
                <option value="gb">Großbritannien</option>
                <option value="ru">Russland</option>
                <option value="cn">China</option>
                <option value="jp">Japan</option>
                <option value="br">Brasilien</option>
            </select>
            <button onClick={handleButtonClick}>Go!</button>
        </div>
    );
}

export default Dropdown;
