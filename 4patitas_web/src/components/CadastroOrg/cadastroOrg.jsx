import React from 'react';
import styles from './cadastroOrg.module.css';
import { useNavigate } from 'react-router-dom';
import { useFormContext } from '/src/contexts/Context/formContext';
import axios from 'axios'; // Import Axios

function CadastroOrg() {
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

      const response = await axios.post('http://localhost:8080/api/4Patitas/ong', {
        nome: formData.nome,
        email: formData.email,
        telefone: formData.telefone,
        endereco: formData.endereco,
        cnpj: formData.cnpj,       
        description: formData.description,  
        pix: formData.pix,       
      });

      console.log('Resposta do servidor:', response.data);
      navigate('/pagina-destino');  
    } catch (error) {
      console.error('Erro ao enviar os dados:', error);
      alert('Erro ao enviar o formulário.');
    }
  };

  return (
    <div className={styles.cadastroOrgContainer}>
      <h2>Cadastro de ONG</h2>
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
          <label htmlFor="cnpj">CNPJ:</label>
          <input
            type="text"
            id="cnpj"
            name="cnpj"
            value={formData.cnpj || ''}
            onChange={handleChange}
            required
          />
        </div>

        <div className={styles.formGroup}>
          <label htmlFor="pix">Pix:</label>
          <input
            type="text"
            id="pix"
            name="pix"
            value={formData.pix || ''}
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

        <button type="submit" className={styles.submitButton}>
          Enviar
        </button>
      </form>
    </div>
  );
}

export default CadastroOrg;
