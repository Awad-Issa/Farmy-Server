package com.farmy.project.farmy.project;

import com.farmy.project.farmy.project.dto.SheepDto;
import com.farmy.project.farmy.project.model.entity.Sheep;
import com.farmy.project.farmy.project.model.mapper.SheepMapper;
import com.farmy.project.farmy.project.model.mapper.SheepMapperImpl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplicationTests {

//	@Autowired
	SheepMapper sheepMapper = new SheepMapperImpl();

	@Test
	public void contextLoads() {
		SheepDto sheepDto = SheepDto.builder().age(1).build();

		Sheep entity = sheepMapper.toEntity(sheepDto);

		Assert.assertNotNull(entity);
		Assert.assertEquals(entity.getAge(), sheepDto.getAge());
		Assert.assertNull(entity.getGender());
	}

	@Test
	public void contextLoads2() {
		Assert.assertEquals(true, true);
	}

}
