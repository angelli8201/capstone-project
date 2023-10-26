import React, { useState, useEffect } from 'react';
import { motion } from 'framer-motion';
import home from '../images/home.avif';
import carousel1 from '../images/carousel1.avif';
import carousel2 from '../images/carousel2.avif';
import carousel3 from '../images/carousel3.avif';
import carousel4 from '../images/carousel4.avif';
import carousel5 from '../images/carousel5.avif';
import carousel6 from '../images/carousel6.avif';
import carousel7 from '../images/carousel7.avif';
import carousel8 from '../images/carousel8.avif';

const legoImages = [
    home,
    carousel1,
    carousel2,
    carousel3,
    carousel4,
    carousel5,
    carousel6,
    carousel7,
    carousel8,

];

function LegoImageCarousel() {
  const [currentImageIndex, setCurrentImageIndex] = useState(0);

  useEffect(() => {
    const interval = setInterval(() => {
      setCurrentImageIndex((prevIndex) => (prevIndex + 1) % legoImages.length);
    }, 2000); 
    return () => {
      clearInterval(interval); 
    };
  }, []);

  return (
    <div>
      <div className="carousel-container">
        <motion.img
          src={legoImages[currentImageIndex]}
          alt="LEGO"
          initial={{ opacity: 0 }}
          animate={{ opacity: 1 }}
          exit={{ opacity: 0 }}
          style={{ width: '1450px', height: '1000px' }}
        />
      </div>
    </div>
  );
}

export default LegoImageCarousel;
