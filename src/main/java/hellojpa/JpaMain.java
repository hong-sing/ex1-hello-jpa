package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //저장
            //비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");

            //영속 -> 바로 DB에 쿼리 나가지 않음. 영속성 컨텍스트에 저장이 되는 것
//            em.persist(member);

//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");
            Member member = em.find(Member.class, 150L);
            member.setName("ZZZZZ");


            System.out.println("====================");

            //조회
//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);

//            System.out.println("result = " + (findMember1 == findMember2));

            //수정
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");

            //전체조회
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5)
//                    .setMaxResults(8)
//                    .getResultList();

//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }


            tx.commit(); //이때 DB에 쿼리가 나감
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
