import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import './index.css';
import './App.css';
import { FormProvider } from '/src/contexts/Context/formContext';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <FormProvider>
    <App />
  </FormProvider>
);