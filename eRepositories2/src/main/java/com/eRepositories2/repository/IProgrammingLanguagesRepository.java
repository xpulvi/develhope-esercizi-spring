package com.eRepositories2.repository;

import com.eRepositories2.entitis.ProgrammingLanguages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author nicolo
 * non ho capito cosa chiede.
 */
/* the repository uses a specific path called repo-prog-languages and it has a description

 @Pasquale non ho capito cosa chiede.
se questo : collectionResourceDescription = @Deprecated(since = "")
 ho questo: //
 */
@RepositoryRestResource(path = "repo-prog-languages" /*, collectionResourceDescription = @Deprecated(since = "") */)
public interface IProgrammingLanguagesRepository extends JpaRepository<ProgrammingLanguages, Long> {

}
