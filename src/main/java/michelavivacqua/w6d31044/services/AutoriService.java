package michelavivacqua.w6d31044.services;

import michelavivacqua.w6d31044.entities.Autore;
import michelavivacqua.w6d31044.exceptions.NotFoundException;
import michelavivacqua.w6d31044.repositories.AutoriDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AutoriService {
    @Autowired
    private AutoriDAO autoreRepository;

    public List<Autore> getAutoriList() {
        return autoreRepository.findAll();
    }

    public Autore saveAutore(Autore body) {
        return autoreRepository.save(body);
    }

    public Autore findById(int id) {
        return autoreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    public Autore findByIdAndUpdate(int id, Autore updatedAutore) {
        Autore found = findById(id);
        found.setNome(updatedAutore.getNome());
        found.setCognome(updatedAutore.getCognome());
        return autoreRepository.save(found);
    }

    public void findByIdAndDelete(int authorId) {
        autoreRepository.deleteById(authorId);
    }
}
