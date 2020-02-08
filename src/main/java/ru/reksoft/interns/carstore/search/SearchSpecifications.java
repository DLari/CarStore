package ru.reksoft.interns.carstore.search;

import org.springframework.data.jpa.domain.Specification;
import ru.reksoft.interns.carstore.entity.*;
import ru.reksoft.interns.carstore.entity.AutoInStock_;
import ru.reksoft.interns.carstore.entity.Color_;
import ru.reksoft.interns.carstore.entity.DictCarcass_;
import ru.reksoft.interns.carstore.entity.Engine_;
import ru.reksoft.interns.carstore.entity.Model_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class SearchSpecifications {

    public static Specification<AutoInStock> findColorId(Integer id) {
    return new Specification<AutoInStock>() {

        public Predicate toPredicate(Root<AutoInStock> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
          if(id==null) {
              return cb.and();
          }
          else {
              return cb.equal(root.get(AutoInStock_.color).get(Color_.id),id);
          }
        }
    };
}
        public static Specification<AutoInStock> findModelId(Integer id) {
        return new Specification<AutoInStock>() {

            public Predicate toPredicate(Root<AutoInStock> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                if (id == null) {
                    return cb.and();
                } else {
                    return cb.equal(root.get(AutoInStock_.model).get(ru.reksoft.interns.carstore.entity.Model_.id),id);
                }
                }
            };
        }

    public static Specification<AutoInStock> findEngineId(Integer id) {
        return new Specification<AutoInStock>() {

            public Predicate toPredicate(Root<AutoInStock> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                if (id == null) {
                    return cb.and();
                } else {
                    return cb.equal(root.get(AutoInStock_.engine).get(Engine_.id), id);
                }
            }
        };
    }
    public static Specification<AutoInStock> findCarcassId(Integer id) {
        return new Specification<AutoInStock>() {

            public Predicate toPredicate(Root<AutoInStock> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                if (id == null) {
                    return cb.and();
                } else {
                    return cb.equal(root.get(AutoInStock_.model).get(Model_.dictCarcass).get(DictCarcass_.id), id);
                }
            }
        };
    }

    public static Specification<Color> findAllNotRemovedColor() {
        return new Specification<Color>() {

            public Predicate toPredicate(Root<Color> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                return cb.isFalse(root.get(Color_.removed));
            }
        };
    }

    public static Specification<Engine> findAllNotRemovedEngine() {
        return new Specification<Engine>() {

            public Predicate toPredicate(Root<Engine> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                return cb.isFalse(root.get(Engine_.removed));
            }
        };
    }

    public static Specification<Model> findAllNotRemovedModel() {
        return new Specification<Model>() {

            public Predicate toPredicate(Root<Model> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                return cb.isFalse(root.get(Model_.removed));
            }
        };
    }

    public static Specification<Orders> findAllDeliveredOrders() {
        return new Specification<Orders>() {

            public Predicate toPredicate(Root<Orders> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get(Orders_.dictOrderStatus).get(DictOrderStatus_.id),4);
            }
        };
    }

    public static Specification<Orders> findAllPaidOrders() {
        return new Specification<Orders>() {

            public Predicate toPredicate(Root<Orders> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get(Orders_.dictOrderStatus).get(DictOrderStatus_.id),3);
            }
        };
    }

    public static Specification<Orders> findAllNotDeliveredNotPaidOrders() {
        return new Specification<Orders>() {

            public Predicate toPredicate(Root<Orders> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.lessThanOrEqualTo(root.get(Orders_.dictOrderStatus).get(DictOrderStatus_.id),2);
            }
        };
    }

    public static Specification<Orders> findOrdersById(Integer id) {
        return new Specification<Orders>() {

            public Predicate toPredicate(Root<Orders> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get(Orders_.users).get(Users_.id),id);
            }
        };
    }

    public static Specification<AutoInStock> findAutoInStock() {
        return new Specification<AutoInStock>() {

            public Predicate toPredicate(Root<AutoInStock> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.greaterThan(root.get(AutoInStock_.presence),0);
            }
        };
    }

}
