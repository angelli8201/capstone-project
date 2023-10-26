import React, { useState, useEffect } from 'react';
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import logo from "../images/icon.png";
import age from "../images/ages.jpg";
import star from "../images/star3.png";
import Button from 'react-bootstrap/Button';

function LegoCard({lego}){
    return(
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
    )
}
export default LegoCard;