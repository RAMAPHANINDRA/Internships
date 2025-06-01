import React,{useEffect,useState} from 'react';
import './App.css';
const App =() => {
  const [data,setData] = useState([]);
   useEffect(() =>{
    fetch('https://fakestoreapi.com/products')
    .then(response => response.json())
    .then(json => setData(json))
   },[])
   return(
    <div>
      <center><h1>Product Catalog</h1></center>
      <div className='Header'>
        {data.map(item => (
        <div key={item.id} className='product-grid'>
          
          <p>{item.title}</p>
          <img src={item.image} alt={item.title}/>
          <span>S{item.price}</span>
        </div>
       ))}
      </div>
       
    </div>
   );
  }
export default App;