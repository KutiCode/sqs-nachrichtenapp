// __tests__/DetailedView.test.js
import React from 'react';
import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect';
import DetailedView from '../DetailedView';

test('renders detailed view with correct content', () => {
    const detail = 'Detailed content';
    render(<DetailedView detail={detail} />);
    expect(screen.getByText(detail)).toBeInTheDocument();
});
