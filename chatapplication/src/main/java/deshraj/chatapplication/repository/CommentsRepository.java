package deshraj.chatapplication.repository;

import deshraj.chatapplication.entity.CommentsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentsRepository extends PagingAndSortingRepository<CommentsEntity,Long> {
   /* Page<CommentsEntity> findByPostId(Long postId, Pageable pageable);
    Optional<CommentsEntity> findByCommentIdAndPostId(Long commentId, Long postId);*/
}