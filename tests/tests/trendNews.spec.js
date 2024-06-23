import { test, expect } from '@playwright/test';

test('trendNewsTest', async ({ page }) => {
    await page.goto('http://localhost:80/');
    await page.getByRole('button', { name: 'Go!' }).first().click();
    await expect(page.locator('div').filter({ hasText: 'Top 10 Ergebnisse deiner' }).nth(3)).toBeVisible();
    await page.getByRole('combobox').selectOption('us');
    await page.getByRole('button', { name: 'Go!' }).first().click();
    await expect(page.locator('div').filter({ hasText: 'Top 10 Ergebnisse deiner' }).nth(3)).toBeVisible();
    await page.getByRole('combobox').selectOption('fr');
    await page.getByRole('button', { name: 'Go!' }).first().click();
    await expect(page.locator('div').filter({ hasText: 'Top 10 Ergebnisse deiner' }).nth(3)).toBeVisible();
    await page.getByRole('combobox').selectOption('it');
    await page.getByRole('button', { name: 'Go!' }).first().click();
    await expect(page.locator('div').filter({ hasText: 'Top 10 Ergebnisse deiner' }).nth(3)).toBeVisible();
    await page.getByRole('combobox').selectOption('es');
    await page.getByRole('button', { name: 'Go!' }).first().click();
    await page.getByRole('combobox').selectOption('gb');
    await page.getByRole('button', { name: 'Go!' }).first().click();
    await expect(page.locator('div').filter({ hasText: 'Top 10 Ergebnisse deiner' }).nth(3)).toBeVisible();
    await page.getByRole('combobox').selectOption('ru');
    await page.getByRole('button', { name: 'Go!' }).first().click();
    await expect(page.locator('div').filter({ hasText: 'Top 10 Ergebnisse deiner' }).nth(3)).toBeVisible();
    await page.getByRole('combobox').selectOption('cn');
    await page.getByRole('button', { name: 'Go!' }).first().click();
    await expect(page.locator('div').filter({ hasText: 'Top 10 Ergebnisse deiner' }).nth(3)).toBeVisible();
    await page.getByRole('combobox').selectOption('jp');
    await expect(page.locator('div').filter({ hasText: 'Top 10 Ergebnisse deiner' }).nth(3)).toBeVisible();
    await page.getByRole('combobox').selectOption('br');
    await page.getByRole('button', { name: 'Go!' }).first().click();
    await expect(page.locator('div').filter({ hasText: 'Top 10 Ergebnisse deiner' }).nth(3)).toBeVisible();
});