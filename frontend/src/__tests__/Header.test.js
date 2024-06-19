// __tests__/Header.test.js
import React from 'react';
import { render } from '@testing-library/react';
import Header from '../components/Header';

test('renders Header and checks for specific text', () => {
    const { getByText } = render(<Header />);

    const expectedElement1 = getByText('Der Nachrichten Portal deines Vertrauens');
    const expectedElement2 = getByText('Bleibe immer up-to-date mit den neuesten Trend Nachrichten deiner Wahl');

    expect(expectedElement1).toBeInTheDocument();
    expect(expectedElement2).toBeInTheDocument();
});