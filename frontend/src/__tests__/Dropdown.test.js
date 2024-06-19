/*import React from 'react';
import { render, screen, fireEvent, waitFor } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect';
import Dropdown from '../components/Dropdown';
import fetchMock from 'jest-fetch-mock';

fetchMock.enableMocks();

beforeEach(() => {
    fetch.resetMocks();
});

test('fetches and displays options from the API when button is clicked', async () => {
    const mockSetTrendingTopics = jest.fn();
    const mockData = {
        articles: [
            { title: 'Article 1' },
            { title: 'Article 2' },
        ]
    };
    fetch.mockResponseOnce(JSON.stringify(mockData));

    render(<Dropdown label="Select a country" setTrendingTopics={mockSetTrendingTopics} />);

    fireEvent.change(screen.getByRole('combobox'), { target: { value: 'us' } });
    fireEvent.click(screen.getByRole('button', { name: /go!/i }));

    expect(fetch).toHaveBeenCalledWith(`http://localhost:8080/news/us/${new Date().toISOString().split('T')[0]}`);

    await waitFor(() => {
        expect(mockSetTrendingTopics).toHaveBeenCalledWith(mockData.articles);
    });
});

test('displays an empty dropdown when there are no options', async () => {
    const mockSetTrendingTopics = jest.fn();
    const mockData = {
        articles: []
    };
    fetch.mockResponseOnce(JSON.stringify(mockData));

    render(<Dropdown label="Select a country" setTrendingTopics={mockSetTrendingTopics} />);

    fireEvent.change(screen.getByRole('combobox'), { target: { value: 'us' } });
    fireEvent.click(screen.getByRole('button', { name: /go!/i }));

    await waitFor(() => {
        expect(mockSetTrendingTopics).toHaveBeenCalledWith([]);
    });
});

test('handles API errors gracefully', async () => {
    const mockSetTrendingTopics = jest.fn();
    fetch.mockReject(new Error('API is down'));

    render(<Dropdown label="Select a country" setTrendingTopics={mockSetTrendingTopics} />);

    fireEvent.change(screen.getByRole('combobox'), { target: { value: 'us' } });
    fireEvent.click(screen.getByRole('button', { name: /go!/i }));

    await waitFor(() => {
        expect(mockSetTrendingTopics).toHaveBeenCalledWith([]);
    });
});*/
import React from 'react';
import { render, screen, fireEvent, waitFor } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect';
import Dropdown from '../components/Dropdown';
import fetchMock from 'jest-fetch-mock';

fetchMock.enableMocks();

beforeEach(() => {
    fetch.resetMocks();
    jest.clearAllMocks(); // Clear all mocks before each test
});

test('fetches and displays options from the API when button is clicked', async () => {
    const mockSetTrendingTopics = jest.fn();
    const mockData = {
        articles: [
            { title: 'Article 1' },
            { title: 'Article 2' },
        ]
    };
    fetch.mockResponseOnce(JSON.stringify(mockData));

    render(<Dropdown label="Select a country" setTrendingTopics={mockSetTrendingTopics} />);

    fireEvent.change(screen.getByRole('combobox'), { target: { value: 'us' } });
    fireEvent.click(screen.getByRole('button', { name: /go!/i }));

    expect(fetch).toHaveBeenCalledWith(`http://localhost:8080/news/us/${new Date().toISOString().split('T')[0]}`);

    await waitFor(() => {
        expect(mockSetTrendingTopics).toHaveBeenCalledWith(mockData.articles);
    });
});

test('displays an empty dropdown when there are no options', async () => {
    const mockSetTrendingTopics = jest.fn();
    const mockData = {
        articles: []
    };
    fetch.mockResponseOnce(JSON.stringify(mockData));

    render(<Dropdown label="Select a country" setTrendingTopics={mockSetTrendingTopics} />);

    fireEvent.change(screen.getByRole('combobox'), { target: { value: 'us' } });
    fireEvent.click(screen.getByRole('button', { name: /go!/i }));

    await waitFor(() => {
        expect(mockSetTrendingTopics).toHaveBeenCalledWith([]);
    });
});

test('handles API errors gracefully', async () => {
    const mockSetTrendingTopics = jest.fn();
    const errorMessage = 'API is down';

    jest.spyOn(console, 'error').mockImplementation(() => {}); // Mock console.error

    fetch.mockReject(new Error(errorMessage));

    render(<Dropdown label="Select a country" setTrendingTopics={mockSetTrendingTopics} />);

    fireEvent.change(screen.getByRole('combobox'), { target: { value: 'us' } });
    fireEvent.click(screen.getByRole('button', { name: /go!/i }));

    await waitFor(() => {
        expect(mockSetTrendingTopics).toHaveBeenCalledWith([]);
    });

    expect(console.error).toHaveBeenCalledWith(new Error(errorMessage));
});
