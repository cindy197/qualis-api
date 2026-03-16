// Endereço base da API
const API = 'http://localhost:8080/api';

// Carrega as áreas da API e popula os dropdowns
async function carregarAreas() {
    const resposta = await fetch(`${API}/areas`);
    const areas = await resposta.json();

    const selectArea = document.getElementById('select-area');
    const selectAreaGrafico = document.getElementById('select-area-grafico');

    areas.forEach(area => {
        const opcao = document.createElement('option');
        opcao.value = area;
        opcao.textContent = area;

        selectArea.appendChild(opcao);
        selectAreaGrafico.appendChild(opcao.cloneNode(true));
    });
}