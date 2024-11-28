import React from 'react';
import styles from './cadastroAdo.module.css';
import { useNavigate } from 'react-router-dom';
import { useFormContext } from '/src/contexts/Context/formContext';
import axios from 'axios'; // Added Axios import for sending data

function CadastroAdo() {
  const { formData, updateFormData } = useFormContext();
  const navigate = useNavigate();

  const handleChange = (event) => {
    const { name, value } = event.target;
    updateFormData({ [name]: value });
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    console.log('Formulário enviado:', formData);

    try {
      
      const response = await axios.post('http://localhost:8080/api/4Patitas/adotante', {
        nome: formData.nome,
        email: formData.email,
        telefone: formData.telefone,
        endereco: formData.endereco,
        cpf: formData.cpf,
        description: formData.description, 
      });

      console.log('Resposta do servidor:', response.data);
      navigate('/pagina-destino'); 
    } catch (error) {
      console.error('Erro ao enviar os dados:', error);
      alert('Erro ao enviar o formulário.');
    }
  };

  return (
    <div className={styles.formContainer}>
      <h2>Formulário de Adoção</h2>
      <form onSubmit={handleSubmit}>
        <div className={styles.formGroup}>
          <label htmlFor="nome">Nome:</label>
          <input
            type="text"
            id="nome"
            name="nome"
            value={formData.nome || ''}
            onChange={handleChange}
            required
          />
        </div>

        <div className={styles.formGroup}>
          <label htmlFor="email">E-mail:</label>
          <input
            type="email"
            id="email"
            name="email"
            value={formData.email || ''}
            onChange={handleChange}
            required
          />
        </div>

        <div className={styles.formGroup}>
          <label htmlFor="telefone">Telefone:</label>
          <input
            type="tel"
            id="telefone"
            name="telefone"
            value={formData.telefone || ''}
            onChange={handleChange}
            required
          />
        </div>

        <div className={styles.formGroup}>
          <label htmlFor="endereco">Endereço:</label>
          <input
            type="text"
            id="endereco"
            name="endereco"
            value={formData.endereco || ''}
            onChange={handleChange}
            required
          />
        </div>

        <div className={styles.formGroup}>
          <label htmlFor="cpf">CPF:</label>
          <input
            type="text"
            id="cpf"
            name="cpf"
            value={formData.cpf || ''}
            onChange={handleChange}
            required
          />
        </div>

        <div className={styles.formGroup}>
          <label htmlFor="description">Descrição:</label>
          <textarea
            id="description"
            name="description"
            value={formData.description || ''}
            onChange={handleChange}
            required
          />
        </div>

        <button type="submit" className={styles.button}>
          Enviar
        </button>
      </form>
    </div>
  );
}

export default CadastroAdo;
