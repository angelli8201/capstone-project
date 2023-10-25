import React, { useState, useEffect } from 'react';
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

function News() {
    const [news, setNews] = useState([]);

    useEffect(() => {
        const fetchNews = async () => {
            try {
                const response = await fetch("http://localhost:8080/api/news");
                if (response.ok) {
                    const newsData = await response.json();
                    setNews(newsData);
                } else {
                    setNews([]);
                }
            } catch (error) {
                console.error("Error fetching news:", error);
            }
        };

        fetchNews();
    }, []);

    return (
        <div className="container">
            {news.map(newsPost => (
            <Row key={newsPost.postId} style={{ marginBottom: '20px', background: 'yellow'}}>
                    <Col >
                        <Card style={{ width: '100%', height: '100%', fontSize: 24, padding: '20px' }}>
                            <Card.Body>
                                <Card.Title style={{fontSize: 36 }}>{newsPost.title}</Card.Title>
                                <Card.Subtitle className="mb-2 text-muted">{newsPost.datePosted}</Card.Subtitle>
                                <Card.Text>{newsPost.caption}</Card.Text>
                            </Card.Body>
                        </Card>
                    </Col>
            </Row>
             ))}
        </div>
    );
}

export default News;