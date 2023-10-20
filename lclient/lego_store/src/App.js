
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Nav from './components/Nav';
import bpic from "./images/lego_wallpaper.jpg";
import Landing from './pages/Landing';
import Themes from './pages/Themes';
import Legos from './pages/Legos';
import Figures from './pages/Figures';
import News from './pages/News';
import React from 'react';
import Success from './pages/Success';
import Cancel from './pages/Cancel';
import CartProvider from './CartContext';
import { useEffect,useState } from "react";




function App() {

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
    return <p>Loading...</p>; 
  }

   function getSetData(legoSetId){
    let setData = legos.find(set => set.legoSetId === legoSetId);
    return setData;
  }

  const containerStyle = {
    background: `url(${bpic}) center / cover no-repeat fixed rgba(255, 255, 255, 0.3)`,
    minHeight: '100vh', 
    display: 'flex',
    flexDirection: 'column',
    backgroundSize: 'cover',
    backgroundPosition: 'center',
    backgroundRepeat: 'no-repeat',
  };
  

  return (
    <CartProvider getSetData={getSetData}>
        <Router>
        <main style={containerStyle}>
        <Nav/>
        <Routes>
          <Route path = "/" element = {<Landing/>}/>
          <Route path = "/themes" element = {<Themes/>}/>
          <Route path = "/legos" element = {<Legos legos = {legos} getSetData={getSetData}/>}/>
          <Route path = "/figures" element = {<Figures/>}/>
          <Route path = "/success" element = {<Success/>}/>
          <Route path = "/cancel" element = {<Cancel/>}/>
        </Routes>  
        </main>
    </Router>
    </CartProvider>
   
  );
}

export default App;