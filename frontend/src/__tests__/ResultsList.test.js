// __tests__/ResultsList.test.js
import React from 'react';
import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect';
import ResultsList from '../components/ResultsList';

test('renders list of results', () => {
    const results = ['Result 1', 'Result 2', 'Result 3'];
    render(<ResultsList results={results} />);
    results.forEach(result => {
        expect(screen.getByText(result)).toBeInTheDocument();
    });
});
