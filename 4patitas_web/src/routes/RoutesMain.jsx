import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import CadastroAdo from '../components/CadastroAdo/cadastroAdo';
import CadastroOrg from '../components/CadastroOrg/cadastroOrg';
import Home from '../pages/Home/home';
import Principal from '../pages/Principal/principal';
import Login from '../pages/Login/login';

function RoutesMain(){
    return(
        <Router>
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/login" element={<Login />} />
                <Route path="/cadastro-ado" element={<CadastroAdo />} />
                <Route path="/cadastro-org" element={<CadastroOrg />} />
                <Route path="/pagina-destino" element={<Principal />} />
            </Routes>
        </Router>
    );
  }
export default RoutesMain;