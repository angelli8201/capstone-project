import React from 'react';
import { motion } from 'framer-motion';
import AnimatedTextWord from '../components/AnimatedTextWord';


function Landing() {
  const containerVariants = {
    hidden: { opacity: 0 },
    visible: { opacity: 1, transition: { duration: 1 } },
  };

  const iframeVariants = {
    hidden: { opacity: 0, x: -100 },
    visible: { opacity: 1, x: 0, transition: { duration: 1 } },
  };

  const textVariants = {
    hidden: { opacity: 0, x: 100 },
    visible: { opacity: 1, x: 0, transition: { duration: 1 } },
  };

  return (
   <div>
    <div className="d-flex justify-content-center">
        <AnimatedTextWord  text="Welcome to a home for Lego lovers" />
    </div>
     <motion.div
      className="container"
      variants={containerVariants}
      initial="hidden"
      animate="visible"
    >
      <motion.div style={{ flex: 1,backgroundColor: 'white', padding: '20px', borderRadius: '8px' }} variants={iframeVariants}>
        <iframe
          width="100%"
          height="720"
          src="https://www.youtube.com/embed/rwQqkX3qZak"
          title="LEGO® Advert: Let's Build"
          frameBorder="0"
          allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
          allowFullScreen
        ></iframe>
      </motion.div>
      <motion.div style={{ flex: 1, padding: '20px' }} variants={textVariants}>
        <motion.div
          style={{ backgroundColor: 'white', padding: '20px', borderRadius: '8px' }}
        >
          <p style={{ fontSize: '30px', margin: 0 }}>
            Welcome to our vibrant LEGO wonderland, where creativity knows no bounds!
            Immerse yourself in the colorful world of bricks and endless possibilities on
            our LEGO website. Whether you're a seasoned builder or just starting your
            LEGO journey, our site is your ultimate destination for all things LEGO.
            Explore a vast array of themes, from iconic sets to the latest releases, and
            discover the joy of constructing your own imaginative worlds. Stay up-to-date
            with the latest LEGO news, uncover insider tips, and dive into the exciting
            universe of LEGO mini-figures. Join our community of passionate LEGO
            enthusiasts, where every click brings you closer to the excitement and
            creativity that LEGO has to offer. Start building, imagining, and connecting
            with fellow fans on our LEGO website—it's a place where the love for bricks
            comes to life!
          </p>
        </motion.div>
      </motion.div>
     
    </motion.div>
    
   </div>
  );
}

export default Landing;
