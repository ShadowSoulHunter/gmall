package com.atguigu.gmall.list;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.SkuInfo;
import com.atguigu.gmall.bean.SkuLsInfo;
import com.atguigu.gmall.service.SkuService;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallListServiceApplicationTests {
	@Autowired
	JestClient jestClient;
	@Reference
	SkuService skuService;

	@Test
	public void contextLoads() {
		List<SkuInfo> skuInfoList = skuService.getSkuListByCatalog3Id("61");
		List<SkuLsInfo> skuLsInfoList = new ArrayList<SkuLsInfo>();
		for (SkuInfo skuInfo : skuInfoList) {
			SkuLsInfo skuLsInfo = new SkuLsInfo();
			try {
				BeanUtils.copyProperties(skuLsInfo,skuInfo);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			skuLsInfoList.add(skuLsInfo);
		}
		for (SkuLsInfo skuLsInfo : skuLsInfoList) {
			Index build = new Index.Builder(skuLsInfo).index("gmall").type("SkuLsInfo").id(skuLsInfo.getId()).build();
			try {
				jestClient.execute(build);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
