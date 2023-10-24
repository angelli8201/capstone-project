import React, { useState, useEffect } from 'react';
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import logo from "../images/icon.png";

function Figures() {
    const [figures, setFigures] = useState([]);

    useEffect(() => {
        const fetchFigures = async () => {
            try {
                const response = await fetch("http://localhost:8080/api/figures");
                if (response.ok) {
                    const figuresData = await response.json();
                    setFigures(figuresData);
                } else {
                    setFigures([]);
                }
            } catch (error) {
                console.error("Error fetching themes:", error);
            }
        };

        fetchFigures();
    }, []);

    return (
        <div className="container">
            <Row style={{ marginBottom: '10px' }}>
                {figures.map(figure => (
                    <Col key={figure.figureId} xs={12} md={4} style={{ marginBottom: '5px' }}>
                        <Card style={{ width: '100%', height: '80%', display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
                            <Card.Img
                                variant="top"
                                src={figure.imageUrl}
                                style={{ height: '80%', objectFit: 'contain' }}
                            />
                            <Card.Body>
                                <Card.Title>{figure.figureName} <img src={logo} alt="Logo" style={{ width: '50px', height: '50px', marginRight: '10px' }} /> {figure.amountOfPieces}</Card.Title>
                            </Card.Body>
                        </Card>
                    </Col>
                ))}
            </Row>
        </div>
    );
}

export default Figures;