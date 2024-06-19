import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect';
import ResultsList from '../components/ResultsList';

test('displays the top 10 trending topics', () => {
    const mockTrendingTopics = [
        { title: 'Article 1', author: 'Author 1' },
        { title: 'Article 2', author: 'Author 2' },
        { title: 'Article 3', author: 'Author 3' },
        { title: 'Article 4', author: 'Author 4' },
        { title: 'Article 5', author: 'Author 5' },
        { title: 'Article 6', author: 'Author 6' },
        { title: 'Article 7', author: 'Author 7' },
        { title: 'Article 8', author: 'Author 8' },
        { title: 'Article 9', author: 'Author 9' },
        { title: 'Article 10', author: 'Author 10' },
        { title: 'Article 11', author: 'Author 11' }
    ];

    render(<ResultsList trendingTopics={mockTrendingTopics} setSelectedArticle={() => {}} />);

    const listItems = screen.getAllByRole('listitem');
    expect(listItems).toHaveLength(10);
    mockTrendingTopics.slice(0, 10).forEach((article, index) => {
        expect(screen.getByText(`${article.title} - ${article.author}`)).toBeInTheDocument();
    });
});

test('each article is clickable and calls setSelectedArticle with correct article', () => {
    const mockTrendingTopics = [
        { title: 'Article 1', author: 'Author 1' },
        { title: 'Article 2', author: 'Author 2' },
    ];
    const mockSetSelectedArticle = jest.fn();

    render(<ResultsList trendingTopics={mockTrendingTopics} setSelectedArticle={mockSetSelectedArticle} />);

    const listItems = screen.getAllByRole('listitem');
    listItems.forEach((item, index) => {
        fireEvent.click(item);
        expect(mockSetSelectedArticle).toHaveBeenCalledWith(mockTrendingTopics[index]);
    });
});
