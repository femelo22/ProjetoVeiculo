package util;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidade.Veiculo;

public class TableModel extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8067112336848026989L;
	private List<Veiculo> lista;
	// vetor de string que serão os nomes das nossas colunas
	private String[] colunas = {"Código", "Modelo", "Marca", "Ano", "Placa"};
	
	// expecificar que a lista seja passada no contrutor da classe : oq nosso jtable vai mostrar
	public TableModel (List<Veiculo> lista) {
		this.lista = lista;
	}

	@Override
	public int getColumnCount() {
		return colunas.length;// retorna o numero de colunas
	}

	@Override
	public int getRowCount() {
		return lista.size();// retorna o tamanho da nossa lista
	}
	@Override
	public String getColumnName(int columnIndex) {
		return colunas[columnIndex]; // retorna o nome das colunas
	}
	@Override
	public Class<?> getColumnClass(int columnIndex){ // tipo de classe do objeto que vai conter em cada linha da Jtable
		return String.class;
	}
	
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {// vai definir o conteudo de cada linha da Jtable
		Veiculo veiculo = lista.get(rowIndex);// pegaq o objeto especifico expecífico da linha
		
		switch(columnIndex) {
		case 0:
			veiculo.setIdveiculo(Long.parseLong(aValue.toString()));
		case 1:
			veiculo.setModelo(aValue.toString());
		case 2:
			veiculo.setMarca(aValue.toString());
		case 3:
			veiculo.setAno(Integer.parseInt(aValue.toString()));
		case 4:
			veiculo.setPlaca(aValue.toString());
		default:
			System.err.println("Indice da coluna é inválido");
		}
		fireTableCellUpdated(rowIndex, columnIndex);// dizer que os dados da tabela foram atualizados
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {// pega as informações da linha
		Veiculo veiculoSelecionado = lista.get(rowIndex);
		Object valueObject = null;
		
		switch(columnIndex) {
		case 0:
			valueObject = veiculoSelecionado.getIdveiculo();
			break;
		case 1:
			valueObject = veiculoSelecionado.getModelo();
			break;
		case 2:
			valueObject = veiculoSelecionado.getMarca();
			break;
		case 3:
			valueObject = veiculoSelecionado.getAno();
			break;
		case 4:
			valueObject = veiculoSelecionado.getPlaca();
			break;
			default:
		}
		return valueObject;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) { //definir que as celulas do Jtable não serão editadas só vizualizar as informações
		return false;
	}
	
	//método que retorna o objeto da linha que a gnt clicar
	public Object getSelecionado(int rowIndex) {
		return lista.get(rowIndex);
	}
	
	//método para att os dados da nossa tabela
	public void atualizaDados(List<Veiculo> novosVeiculos) {
		this.lista = novosVeiculos;
		fireTableDataChanged();// informa que aconteceu uma mudança na nossa tabela
	}
	
	public void limpar() {// limpar a lista
		lista.clear();
		fireTableDataChanged();
	}
	
	public boolean listaVazia() {
		return lista.isEmpty();
	}

	public void refreshData(List<Veiculo> novosVeiculos) {
		this.lista = novosVeiculos;
		fireTableDataChanged();
		
	}


}
