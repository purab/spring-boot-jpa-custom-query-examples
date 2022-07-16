package in.purabtech.customquery.repository;

import in.purabtech.customquery.model.Tutorial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

    //JPA Select query with where condition example
    @Query("SELECT t FROM Tutorial t")
    List<Tutorial> findAll();
    @Query("SELECT t FROM Tutorial t WHERE t.published=?1")
    List<Tutorial> findByPublished(boolean isPublished);
    @Query("SELECT t FROM Tutorial t WHERE t.title LIKE %?1%")
    List<Tutorial> findByTitleLike(String title);
    @Query("SELECT t FROM Tutorial t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', ?1,'%'))")
    List<Tutorial> findByTitleLikeCaseInsensitive(String title);

    //JPA Query Greater Than or Equal To
    @Query("SELECT t FROM Tutorial t WHERE t.level >= ?1")
    List<Tutorial> findByLevelGreaterThanEqual(int level);
    @Query("SELECT t FROM Tutorial t WHERE t.createdAt >= ?1")
    List<Tutorial> findByDateGreaterThanEqual(Date date);

    //JPA Query Between
    @Query("SELECT t FROM Tutorial t WHERE t.level BETWEEN ?1 AND ?2")
    List<Tutorial> findByLevelBetween(int start, int end);
    @Query("SELECT t FROM Tutorial t WHERE t.createdAt BETWEEN ?1 AND ?2")
    List<Tutorial> findByDateBetween(Date start, Date end);

    //JPA Query example with parameters
    @Query("SELECT t FROM Tutorial t WHERE t.published=:isPublished AND t.level BETWEEN :start AND :end")
    List<Tutorial> findByLevelBetween(@Param("start") int start, @Param("end") int end, @Param("isPublished") boolean isPublished);

    //JPA Query Order By Desc/Asc
    @Query("SELECT t FROM Tutorial t ORDER BY t.level DESC")
    List<Tutorial> findAllOrderByLevelDesc();
    @Query("SELECT t FROM Tutorial t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', ?1,'%')) ORDER BY t.level ASC")
    List<Tutorial> findByTitleOrderByLevelAsc(String title);
    @Query("SELECT t FROM Tutorial t WHERE t.published=true ORDER BY t.createdAt DESC")
    List<Tutorial> findAllPublishedOrderByCreatedDesc();

    //JPA Query Sort By
    @Query("SELECT t FROM Tutorial t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', ?1,'%'))")
    List<Tutorial> findByTitleAndSort(String title, Sort sort);
    @Query("SELECT t FROM Tutorial t WHERE t.published=?1")
    List<Tutorial> findByPublishedAndSort(boolean isPublished, Sort sort);

    //JPA Query Pagination
    @Query("SELECT t FROM Tutorial t")
    Page<Tutorial> findAllWithPagination(Pageable pageable);

    //JPA Query Update
    @Transactional
    @Modifying
    @Query("UPDATE Tutorial t SET t.published=true WHERE t.id=?1")
    int publishTutorial(Long id);

    //Run Spring JPA Query project







}
