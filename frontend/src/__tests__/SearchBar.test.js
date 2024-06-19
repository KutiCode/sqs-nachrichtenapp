// __tests__/SearchBar.test.js
import React from 'react';
import { render, fireEvent } from '@testing-library/react';
import SearchBar from '../components/SearchBar';

test('renders search bar and handles input change', () => {
    const handleSearchResults = jest.fn();
    const { getByPlaceholderText } = render(<SearchBar placeholder="Suche nach was bestimmten" onSearchResults={handleSearchResults} />);

    const input = getByPlaceholderText("Suche nach was bestimmten");
    fireEvent.change(input, { target: { value: 'test query' } });

    expect(input.value).toBe('test query');
});