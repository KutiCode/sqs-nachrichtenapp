import React from 'react';

function Dropdown({ label }) {
    return (
        <div className="dropdown">
            <label>{label}</label>
            <select>
                <option>Deutschland</option>
                <option>USA</option>
                <option>China</option>
                <option>Japan</option>
            </select>
            <button>Go!</button>
        </div>
    );
}

export default Dropdown;
