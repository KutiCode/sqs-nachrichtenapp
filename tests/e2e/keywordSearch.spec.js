import { test, expect } from '@playwright/test';

test('test', async ({ page }) => {
    await page.goto('http://localhost:3000/');
    await page.getByPlaceholder('Suche nach was bestimmten').click();
    await page.locator('div').filter({ hasText: /^Go!$/ }).getByRole('button').click();
    await expect(page.getByText('Top 10 Ergebnisse deiner AuswahlBitte wählen Sie einen Artikel aus.')).toBeVisible();
    await page.getByPlaceholder('Suche nach was bestimmten').click();
    await page.getByPlaceholder('Suche nach was bestimmten').fill('Bitcoin');
    await page.locator('div').filter({ hasText: /^Go!$/ }).getByRole('button').click();
    await expect(page.locator('div').filter({ hasText: 'Top 10 Ergebnisse deiner' }).nth(3)).toBeVisible();
    await expect(page.getByText('Bitcoin and Ethereum ETNs')).toBeVisible();
    await expect(page.getByText('Bitcoin and Ethereum stable')).toBeVisible();
});