import { test, expect } from '@playwright/test';

test('sindAlleElementeSichtbarTest', async ({ page }) => {
    await page.goto('http://localhost:3000/');
    await expect(page.getByText('Der Nachrichten Portal deines VertrauensBleibe immer up-to-date mit den')).toBeVisible();
    await expect(page.getByRole('heading', { name: 'Der Nachrichten Portal deines' })).toBeVisible();
    await expect(page.getByText('Bleibe immer up-to-date mit')).toBeVisible();
    await expect(page.getByText('Lasse dir die Trend')).toBeVisible();
    await expect(page.getByText('Anleitung: Benutze eine der M')).toBeVisible();
    await expect(page.getByText('Wähle ein Land aus')).toBeVisible();
    await expect(page.getByRole('combobox')).toBeVisible();
    await expect(page.getByRole('button', { name: 'Go!' }).first()).toBeVisible();
    await expect(page.getByPlaceholder('Suche nach was bestimmten')).toBeVisible();
    await expect(page.getByRole('heading', { name: 'Top 10 Ergebnisse deiner' })).toBeVisible();
    await expect(page.getByText('Top 10 Ergebnisse deiner AuswahlBitte wählen Sie einen Artikel aus.')).toBeVisible();
    await expect(page.getByText('Bitte wählen Sie einen')).toBeVisible();
    await expect(page.locator('div').filter({ hasText: 'Lasse dir die Trend' }).nth(3)).toBeVisible();
});