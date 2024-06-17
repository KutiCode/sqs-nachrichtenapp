import React from 'react';

function ResultsList({ trendingTopics, setSelectedArticle }) {
    return (
        <div className="results-list">
            <h2>Top 10 Ergebnisse deiner Auswahl</h2>
            <ul>
                {trendingTopics.slice(0, 10).map((article, index) => (
                    <li key={index} onClick={() => setSelectedArticle(article)}>
                        {article.title} - {article.author}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default ResultsList;
