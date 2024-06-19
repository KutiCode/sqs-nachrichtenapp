import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect';
import Dropdown from '../components/Dropdown';

describe('Dropdown Component', () => {
    const setTrendingTopics = jest.fn();

    beforeEach(() => {
        fetch.resetMocks();
    });

    test('renders dropdown correctly', () => {
        render(<Dropdown label="Select Country" setTrendingTopics={setTrendingTopics} />);

        expect(screen.getByLabelText(/Select Country/i)).toBeInTheDocument();
        expect(screen.getByRole('combobox')).toBeInTheDocument();
        expect(screen.getByText('Go!')).toBeInTheDocument();
    });

    test('sends correct fetch request on Go! click', async () => {
        fetch.mockResponseOnce(JSON.stringify({ articles: ['Article 1', 'Article 2'] }));

        render(<Dropdown label="Select Country" setTrendingTopics={setTrendingTopics} />);

        const selectElement = screen.getByRole('combobox');
        fireEvent.change(selectElement, { target: { value: 'us' } });
        expect(selectElement.value).toBe('us');

        const goButton = screen.getByText('Go!');
        fireEvent.click(goButton);

        const currentDate = new Date().toISOString().split('T')[0];
        expect(fetch).toHaveBeenCalledWith(`http://localhost:8080/news/us/${currentDate}`);

        await screen.findByText('Go!');
        expect(setTrendingTopics).toHaveBeenCalledWith(['Article 1', 'Article 2']);
    });

    test('handles fetch errors gracefully', async () => {
        fetch.mockReject(() => Promise.reject('API is down'));

        render(<Dropdown label="Select Country" setTrendingTopics={setTrendingTopics} />);

        const selectElement = screen.getByRole('combobox');
        fireEvent.change(selectElement, { target: { value: 'de' } });
        expect(selectElement.value).toBe('de');

        const goButton = screen.getByText('Go!');
        fireEvent.click(goButton);

        await waitFor(() => expect(setTrendingTopics).toHaveBeenCalledWith([]));
    });
});
