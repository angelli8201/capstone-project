import React, { useState, useEffect } from 'react';
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

function Themes() {
    const [themes, setThemes] = useState([]);

    useEffect(() => {
        const fetchThemes = async () => {
            try {
                const response = await fetch("http://localhost:8080/api/themes");
                if (response.ok) {
                    const themesData = await response.json();
                    setThemes(themesData);
                } else {
                    setThemes([]);
                }
            } catch (error) {
                console.error("Error fetching themes:", error);
            }
        };

        fetchThemes();
    }, []);

    return (
        <div className="container">
            <Row>
                {themes.map(theme => (
                    <Col key={theme.themeId} xs={12} md={4} style={{ marginBottom: '20px' }}>
                        <Card style={{ width: '100%', height: '100%' }}>
                            <Card.Img variant="top" src={theme.themeUrl} />
                            <Card.Body>
                                <Card.Title>{theme.themeName}</Card.Title>
                                <Card.Text>{theme.themeDescription}</Card.Text>
                            </Card.Body>
                        </Card>
                    </Col>
                ))}
            </Row>
        </div>
    );
}

export default Themes;