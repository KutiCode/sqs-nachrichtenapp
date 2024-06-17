import React from 'react';

function DetailedView({ selectedArticle }) {
    if (!selectedArticle) {
        return <div className="detailed-view">Bitte wählen Sie einen Artikel aus.</div>;
    }

    return (
        <div className="detailed-view">
            <h2>{selectedArticle.title}</h2>
            {selectedArticle.content ? (
                <p>{selectedArticle.content}</p>
            ) : (
                <p>Inhalt in der URL nachzulesen: <a href={selectedArticle.url} target="_blank" rel="noopener noreferrer">Hier klicken</a></p>
            )}
        </div>
    );
}

export default DetailedView;
