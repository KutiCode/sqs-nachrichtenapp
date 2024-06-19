// __tests__/App.test.js
import React from 'react';
import { render, fireEvent } from '@testing-library/react';
import App from '../App';

test('renders App and handles search bar input change', () => {
    const { getByPlaceholderText } = render(<App />);

    const input = getByPlaceholderText("Suche nach was bestimmten");
    fireEvent.change(input, { target: { value: 'test query' } });

    expect(input.value).toBe('test query');
});