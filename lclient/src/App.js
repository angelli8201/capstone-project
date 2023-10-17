
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Nav from './components/Nav';
import bpic from "./images/lego_wallpaper.jpg";
import Landing from './pages/Landing';
import Themes from './pages/Themes';
import Legos from './pages/Legos';
import Figures from './pages/Figures';
import News from './pages/News';




function App() {

  const containerStyle = {
    background: `url(${bpic}) center / cover no-repeat fixed rgba(255, 255, 255, 0.3)`,
    minHeight: '100vh', // Ensure the container covers at least the height of the viewport
    display: 'flex',
    flexDirection: 'column',
    backgroundSize: 'cover',
    backgroundPosition: 'center',
    backgroundRepeat: 'no-repeat',
  };

  return (
    <Router>
      <main style={containerStyle}>
        <Nav/>
        <Routes>
          <Route path = "/" element = {<Landing/>}/>
          <Route path = "/themes" element = {<Themes/>}/>
          <Route path = "/legos" element = {<Legos/>}/>
          <Route path = "/news" element = {<News/>}/>
          <Route path = "/figures" element = {<Figures/>}/>
        </Routes>  
        </main>
    </Router>
  );
}

export default App;