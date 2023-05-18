package com.app.citizen.repository;

import com.app.citizen.config.RootConfig;
import com.app.citizen.config.WebConfig;
import com.app.citizen.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
public class ResidentRepositoryTest {
  @Autowired
  private FamilyRelationshipRepository familyRelationshipRepository;

  @Test
  void test() {
    List<FamilyRelationship> familyRelationships = familyRelationshipRepository.findBy();
    assertThat(familyRelationships.size()).isEqualTo(4);
  }

}
