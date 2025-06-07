package com.saveCash.infra.database.repository;

import com.saveCash.domain.entities.RecoverPass;
import com.saveCash.domain.mappers.UserUseCaseMapper;
import com.saveCash.domain.repositories.RecoverPassRepository;
import com.saveCash.infra.database.schemas.RecoverPassEntity;
import com.saveCash.infra.mappers.RecoverPassInfraMapper;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@RequestScoped
public class RecoverPassRepositoryImpl implements PanacheRepository<RecoverPassEntity>, RecoverPassRepository {

    @Inject
    UserUseCaseMapper userUseCaseMapper;

    @Inject
    RecoverPassInfraMapper recoverPassInfraMapper;

    @Transactional
    public void pesistOtpCode(RecoverPass recoverPass){
        RecoverPassEntity entity = new RecoverPassEntity();
        entity.setUser(userUseCaseMapper.toRepository(recoverPass.getUser()));
        entity.setExpires(recoverPass.getExpires());
        entity.setOtpCode(recoverPass.getOtpCode());

        persist(entity);
    }

    public RecoverPass getOtpCode(Long idUser){
        RecoverPassEntity entity = find(" user.id = ?1", idUser).firstResult();
        return recoverPassInfraMapper.toUseCase(entity);
    }
}
