package learn.data;

import learn.models.LegoMiniFigure;

import java.util.List;

public interface LegoMiniFigureRepository {
    List<LegoMiniFigure> findAll();
    LegoMiniFigure findById(int figureId);

}
