package group5.duan.library.repository;

import group5.duan.library.entity.BorrowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BorrowRepository extends JpaRepository<BorrowEntity, UUID> {
    List<BorrowEntity> findAll();
    BorrowEntity save(BorrowEntity borrowEntity);
    BorrowEntity findFirstByBorrowId(UUID borrowId);
    boolean deleteByBorrowId(UUID borrowId);
    BorrowEntity saveAndFlush(BorrowEntity borrowEntity);
}
