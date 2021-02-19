package br.com.livraria.bean;

import br.com.livraria.bean.entity.LivroEntity;
import br.com.livraria.dao.GenericDao;
import br.com.livraria.model.AutorModel;
import br.com.livraria.model.EditoraModel;
import br.com.livraria.model.LivroModel;

import javax.faces.bean.ManagedBean;
import java.time.LocalDate;
import java.util.Collection;

@ManagedBean
public class LivroBean {

    private LivroEntity livroEntity = new LivroEntity();

    public LivroEntity getLivroEntity() {
        return livroEntity;
    }

    public void gravar() {
        final GenericDao<LivroModel> dao = new GenericDao<>();
        final LivroModel model = new LivroModel();
        model.setAutor(getAutorModel());
        model.setEditora(getEditoraModel());
        model.setDataLancamento(convertStringToDate(livroEntity.getDataLancamento()));
        model.setPaginas(livroEntity.getPaginas());
        model.setSummary(livroEntity.getSummary());
        model.setTitulo(livroEntity.getTitulo());
        model.setValorUnitario(livroEntity.getValorUnitario());
        dao.adiciona(model);
        livroEntity = new LivroEntity();
    }

    private EditoraModel getEditoraModel() {
        final GenericDao<EditoraModel> dao = new GenericDao<>();
        return dao.buscaPorId(EditoraModel.class, livroEntity.getEditora());
    }

    private AutorModel getAutorModel() {
        final GenericDao<AutorModel> dao = new GenericDao<>();
        return dao.buscaPorId(AutorModel.class, livroEntity.getAutor());
    }

    private LocalDate convertStringToDate(final String data) {
        final int dia = new Integer(data.substring(0, 2));
        final int mes = new Integer(data.substring(3, 5));
        final int ano = new Integer(data.substring(6, 10));
        return LocalDate.of(ano, mes, dia);
    }

    public Collection<AutorModel> getTodosAutores() {
        final GenericDao<AutorModel> dao = new GenericDao<>();
        return dao.listaTodos(AutorModel.class);

    }

    public Collection<EditoraModel> getTodasEditoras() {
        final GenericDao<EditoraModel> dao = new GenericDao<>();
        return dao.listaTodos(EditoraModel.class);

    }
}
