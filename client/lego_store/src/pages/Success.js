import React from 'react';
import Card from 'react-bootstrap/Card';
import Button from 'react-bootstrap/Button';
import { useNavigate } from 'react-router-dom'; 

function Success() {
  const cardStyle = {
    width: '36rem',
  };

  const gifContainerStyle = {
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    height: '500px',
  };
  const navigate = useNavigate();

  const redirectToHome = () => {
    navigate('/');
  };

  const redirectToLegos = () => {
    navigate('/legos');
  };

  return (
    <div className="d-flex justify-content-center">
      <Card style={cardStyle}>
        <div style={gifContainerStyle}>
          <iframe
            src="https://giphy.com/embed/nwPGMZwKkNRSzLgLDP"
            width="800"
            height="600"
            frameBorder="0"
            className="giphy-embed"
            allowFullScreen
          ></iframe>
        </div>
        <Card.Body>
          <Card.Title style={{ fontSize: '36px' }}>Successfully purchased!</Card.Title>
          <Card.Text style={{ fontSize: '24px' }}>
            Congratulations! Your LEGO order has been successfully confirmed. Get ready to embark on an exciting building journey as your selected LEGO sets are on their way to your doorstep. We can't wait to see the incredible creations you'll bring to life with your new LEGO bricks. Thank you for choosing LEGO – where creativity and imagination know no bounds. Enjoy your building adventure!
          </Card.Text>
          <Button variant="primary" onClick={redirectToHome}>Go back to home page</Button>
          <Button variant="primary" style={{ marginLeft: '10px' }} onClick={redirectToLegos}>Explore more legos!</Button> 
        </Card.Body>
      </Card>
    </div>
  );
}

export default Success;
