import React from 'react';
import styles from './cadastroAdo.module.css';
import { useNavigate } from 'react-router-dom';
import { useFormContext } from '/src/contexts/Context/formContext';

function CadastroAdo() {
  const { formData, updateFormData } = useFormContext();
  const navigate = useNavigate();

  const handleChange = (event) => {
    const { name, value } = event.target;
    updateFormData({ [name]: value });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    console.log('Formulário enviado:', formData);
    navigate('/pagina-destino');
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
          <label htmlFor="adocao">Adoção:</label>
          <select
            id="adocao"
            name="adocao"
            value={formData.adocao || ''}
            onChange={handleChange}
            required
          >
            <option value="">Selecione uma opção</option>
            <option value="adotar">Adotar</option>
            <option value="não_adotar">Não adotar</option>
          </select>
        </div>

        <div className={styles.formGroup}>
          <label>Oferecer lar temporário?</label>
          <label>
            <input
              type="radio"
              name="larTemporario"
              value="sim"
              checked={formData.larTemporario === 'sim'}
              onChange={handleChange}
            />
            Sim
          </label>
          <label>
            <input
              type="radio"
              name="larTemporario"
              value="nao"
              checked={formData.larTemporario === 'nao'}
              onChange={handleChange}
            />
            Não
          </label>
        </div>

        <button type="submit" className={styles.button}>
          Enviar
        </button>
      </form>
    </div>
  );
}

export default CadastroAdo;


