import React from 'react';
import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect';
import DetailedView from '../components/DetailedView';

test('displays message to select an article when no article is selected', () => {
    render(<DetailedView selectedArticle={null} />);
    expect(screen.getByText('Bitte wählen Sie einen Artikel aus.')).toBeInTheDocument();
});

test('displays article content when article is selected', () => {
    const selectedArticle = { title: 'Article 1', content: 'Content of Article 1', url: 'http://example.com/1' };
    render(<DetailedView selectedArticle={selectedArticle} />);
    expect(screen.getByText('Article 1')).toBeInTheDocument();
    expect(screen.getByText('Content of Article 1')).toBeInTheDocument();
});

test('displays article URL when content is not available', () => {
    const selectedArticle = { title: 'Article 2', content: '', url: 'http://example.com/2' };
    render(<DetailedView selectedArticle={selectedArticle} />);
    expect(screen.getByText('Article 2')).toBeInTheDocument();
    expect(screen.getByText('Inhalt in der URL nachzulesen:')).toBeInTheDocument();
    const linkElement = screen.getByText('Hier klicken');
    expect(linkElement).toBeInTheDocument();
    expect(linkElement).toHaveAttribute('href', 'http://example.com/2');
});
