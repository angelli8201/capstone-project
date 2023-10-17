import React, { useState, useEffect } from 'react';
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import logo from "../images/icon.png";
import age from "../images/ages.jpg";
import star from "../images/star3.png";
import Button from 'react-bootstrap/Button';

function Legos() {
    const [legos, setLegos] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const fetchLegos = async () => {
            try {
                const response = await fetch("http://localhost:8080/api/legos");
                if (response.ok) {
                    const legosData = await response.json();
                    setLegos(legosData);
                } else {
                    setLegos([]);
                }
            } catch (error) {
                console.error("Error fetching legos:", error);
            } finally {
                setLoading(false);
            }
        };

        fetchLegos();
    }, []);

    if (loading) {
        return <p>Loading...</p>; // You can replace this with a loading spinner or any other UI element
    }

    return (
        <div className="container">
            <Row>
                {legos.map(lego => (
                    <Col key={lego.legoSetId} xs={12} md={4} style={{ marginBottom: '20px' }}>
                        <Card style={{ width: '100%', height: '100%', display: 'flex', flexDirection: 'column' }}>
                            <Card.Img
                                variant="top"
                                src={lego.imageUrl}
                                alt={`${lego.setName} Image`}
                                style={{ height: '100%', objectFit: 'contain' }}
                            />
                            <Card.Body style={{ textAlign: 'center' }}>
                                <Card.Title>{lego.setName}&nbsp;&nbsp;&nbsp;&nbsp; {lego.price}</Card.Title>
                                <Card.Text>{lego.description}</Card.Text>
                                <Card.Text >
                                    <img src={logo} alt="Logo" style={{ width: '50px', height: '50px', marginRight: '10px' }} /> {lego.amountOfPieces} 
                                    <img src={age} alt="Logo" style={{ width: '30px', height: '30px', margin: '0 10px' }} /> {lego.ages} 
                                    <img src={star} alt="Logo" style={{ width: '30px', height: '30px', marginLeft: '10px' }} />  {lego.rating}&nbsp;
                                    <Button variant="primary">Add to Cart</Button>
                                </Card.Text>
                                
                            </Card.Body>
                        </Card>
                    </Col>
                ))}
            </Row>
        </div>
    );
}

export default Legos;