package com.room414.taxipark.application.model.repositories;

import com.room414.taxipark.application.model.entities.Entity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Description goes here.
 *
 * @author Alexander Melashchenko
 * @version 1.0 09 Feb 2017
 */
class TreeMapRepositoryTest {
    @Test
    void createFind() {
        Entity<Integer> entity = new Entity<Integer>() {
            @Override
            public Integer getId() {
                return 1;
            }
        };
        TreeMapRepository<Integer, Entity<Integer>> repository = new TreeMapRepository<>();

        repository.create(entity);

        assert  entity == repository.find(1);
    }

    @Test
    void createThrows() {
        Entity<Integer> entity1 = new Entity<Integer>() {
            @Override
            public Integer getId() {
                return 1;
            }
        };
        Entity<Integer> entity2 = new Entity<Integer>() {
            @Override
            public Integer getId() {
                return 1;
            }
        };
        Entity<Integer> entityResult;
        TreeMapRepository<Integer, Entity<Integer>> repository = new TreeMapRepository<>();

        repository.create(entity1);

        assert  entity1 == repository.find(1);

        assertThrows(IllegalArgumentException.class, () -> repository.create(entity2));
    }

    @Test
    void findAll() {
        Entity<Integer> entity1 = new Entity<Integer>() {
            @Override
            public Integer getId() {
                return 1;
            }
        };
        Entity<Integer> entity2 = new Entity<Integer>() {
            @Override
            public Integer getId() {
                return 2;
            }
        };
        Entity<Integer> entity3 = new Entity<Integer>() {
            @Override
            public Integer getId() {
                return 3;
            }
        };
        TreeMapRepository<Integer, Entity<Integer>> repository = new TreeMapRepository<>();

        repository.create(entity1);
        repository.create(entity2);
        repository.create(entity3);

        List<Entity<Integer>> entities = repository.findAll();

        assert entities.size() == 3;
        assert entities.contains(entity1);
        assert entities.contains(entity2);
        assert entities.contains(entity3);
    }

    @Test
    void update() {
        Entity<Integer> entity1 = new Entity<Integer>() {
            @Override
            public Integer getId() {
                return 1;
            }
        };
        Entity<Integer> entity2 = new Entity<Integer>() {
            @Override
            public Integer getId() {
                return 1;
            }
        };
        TreeMapRepository<Integer, Entity<Integer>> repository = new TreeMapRepository<>();

        repository.create(entity1);

        assert entity1 == repository.find(1);

        repository.update(entity2);

        assert entity2 == repository.find(1);
    }

    @Test
    void delete() {
        Entity<Integer> entity1 = new Entity<Integer>() {
            @Override
            public Integer getId() {
                return 1;
            }
        };
        TreeMapRepository<Integer, Entity<Integer>> repository = new TreeMapRepository<>();

        repository.create(entity1);

        assert entity1 == repository.find(1);

        repository.delete(1);

        assert repository.findAll().size() == 0;
        assert repository.find(1) == null;
    }
}