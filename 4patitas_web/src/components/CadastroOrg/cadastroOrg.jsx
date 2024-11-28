import React from 'react';
import styles from './cadastroOrg.module.css';
import { useNavigate } from 'react-router-dom';
import { useFormContext } from '/src/contexts/Context/formContext';

function CadastroOrg() {
  const { formData, updateFormData } = useFormContext();
  const navigate = useNavigate();

  const handleChange = (event) => {
    const { name, value } = event.target;
    updateFormData({ [name]: value });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    console.log('Dados do formulário:', formData);
    navigate('/pagina-destino');
  };

  return (
    <div className={styles.cadastroOngContainer}>
      <h2>Cadastro de ONG</h2>
      <form onSubmit={handleSubmit}>
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
          <label htmlFor="email">Email:</label>
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
        <button type="submit" className={styles.submitButton}>Enviar</button>
      </form>
    </div>
  );
}

export default CadastroOrg;
