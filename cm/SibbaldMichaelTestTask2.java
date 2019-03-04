package cm;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class SibbaldMichaelTestTask2 {
	
	double maxValue = Double.MAX_VALUE;
	
	
	@Test
	public void testCase1() {
		CarParkKind kind = CarParkKind.STAFF;
		BigDecimal normalRate = new BigDecimal("5.2");
		BigDecimal reducedRate = new BigDecimal("3.1");
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		Period normalP = new Period(7, 10);
		Period reducedP = new Period(10,15);
		normalPeriods.add(normalP);
		reducedPeriods.add(reducedP);
		Rate rate = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);		
		
		assertNotNull(rate);
		
	}
	@Test
	public void testCase2() {
		CarParkKind kind = CarParkKind.STAFF;
		BigDecimal normalRate = new BigDecimal(maxValue);
		BigDecimal reducedRate = new BigDecimal("3.1");
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		Period normalP = new Period(7, 10);
		Period reducedP = new Period(10,15);
		normalPeriods.add(normalP);
		reducedPeriods.add(reducedP);
		Rate rate = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);		
		
		assertNotNull(rate);
		
	}
	@Test
	public void testCase3() {
		CarParkKind kind = CarParkKind.STAFF;
		BigDecimal normalRate = new BigDecimal("0");
		BigDecimal reducedRate = new BigDecimal("0");
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		Period normalP = new Period(7, 10);
		Period reducedP = new Period(10,15);
		normalPeriods.add(normalP);
		reducedPeriods.add(reducedP);
		try {
			Rate rate = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
			assertNotNull(rate);
		}catch(IllegalArgumentException expected){	
		}
		
	}
	@Test
	public void testCase4() {
		CarParkKind kind = CarParkKind.STAFF;
		BigDecimal normalRate = new BigDecimal(".01");
		BigDecimal reducedRate = new BigDecimal("0");
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		Period normalP = new Period(7, 10);
		Period reducedP = new Period(10,15);
		normalPeriods.add(normalP);
		reducedPeriods.add(reducedP);
		Rate rate = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);		
		
		assertNotNull(rate);
		
	}
	@Test
	public void testCase5(){
		CarParkKind kind = CarParkKind.STAFF;
		BigDecimal normalRate = new BigDecimal("1");
		BigDecimal reducedRate = new BigDecimal("3");
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		Period normalP = new Period(7, 10);
		Period reducedP = new Period(10,15);
		normalPeriods.add(normalP);
		reducedPeriods.add(reducedP);
		try {
			Rate rate = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
			assertNotNull(rate);
		}catch(IllegalArgumentException expected){	
		}
		
	}
	@Test
	public void testCase6() {
		CarParkKind kind = CarParkKind.STAFF;
		BigDecimal normalRate = new BigDecimal("-1");
		BigDecimal reducedRate = new BigDecimal("0");
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		Period normalP = new Period(7, 10);
		Period reducedP = new Period(10,15);
		normalPeriods.add(normalP);
		reducedPeriods.add(reducedP);
		
		try {
			Rate rate = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
			assertNotNull(rate);
		}catch(IllegalArgumentException expected){	
		}
		
	}
	@Test
	public void testCase7() {
		try {
			CarParkKind kind = CarParkKind.STAFF;
			BigDecimal normalRate = new BigDecimal("5.2");
			BigDecimal reducedRate = new BigDecimal("3.1");
			ArrayList<Period> normalPeriods = new ArrayList<Period>();
			ArrayList<Period> reducedPeriods = new ArrayList<Period>();
			Period normalP = new Period(-1, 10);
			Period reducedP = new Period(10,15);
			normalPeriods.add(normalP);
			reducedPeriods.add(reducedP);
			Rate rate = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
			assertNotNull(rate);
		}catch(IllegalArgumentException expected){	
		}
		
		
	}
	@Test
	public void testCase8() {
		try {
			CarParkKind kind = CarParkKind.STAFF;
			BigDecimal normalRate = new BigDecimal("5.2");
			BigDecimal reducedRate = new BigDecimal("3.1");
			ArrayList<Period> normalPeriods = new ArrayList<Period>();
			ArrayList<Period> reducedPeriods = new ArrayList<Period>();
			Period normalP = new Period(7, 11);
			Period reducedP = new Period(10,15);
			normalPeriods.add(normalP);
			reducedPeriods.add(reducedP);
			Rate rate = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
			assertNotNull(rate);
		}catch(IllegalArgumentException expected){	
		}
		
	}
	@Test
	public void testCase9() {
		try {
			CarParkKind kind = CarParkKind.STAFF;
			BigDecimal normalRate = new BigDecimal("5.2");
			BigDecimal reducedRate = new BigDecimal("3.1");
			ArrayList<Period> normalPeriods = new ArrayList<Period>();
			ArrayList<Period> reducedPeriods = new ArrayList<Period>();
			Period normalP = new Period(7, 10);
			Period reducedP = new Period(10,28);
			normalPeriods.add(normalP);
			reducedPeriods.add(reducedP);
			Rate rate = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
			assertNotNull(rate);
		}catch(IllegalArgumentException expected){	
		}
	}
	@Test
	public void testCase10() {
		try {
			CarParkKind kind = CarParkKind.STAFF;
			BigDecimal normalRate = new BigDecimal("5.2");
			BigDecimal reducedRate = new BigDecimal("-1");
			ArrayList<Period> normalPeriods = new ArrayList<Period>();
			ArrayList<Period> reducedPeriods = new ArrayList<Period>();
			Period normalP = new Period(7, 10);
			Period reducedP = new Period(10,15);
			normalPeriods.add(normalP);
			reducedPeriods.add(reducedP);
			Rate rate = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
			assertNotNull(rate);
		}catch(IllegalArgumentException expected){	
		}
		
	}
	@Test
	public void testCase11() {
		try {
			CarParkKind kind = CarParkKind.STAFF;
			BigDecimal normalRate = null;
			BigDecimal reducedRate = new BigDecimal("3.1");
			ArrayList<Period> normalPeriods = new ArrayList<Period>();
			ArrayList<Period> reducedPeriods = new ArrayList<Period>();
			Period normalP = new Period(7, 10);
			Period reducedP = new Period(10,15);
			normalPeriods.add(normalP);
			reducedPeriods.add(reducedP);
			Rate rate = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
			assertNotNull(rate);
		}catch(IllegalArgumentException expected){	
		}
		
	}
	@Test
	public void testCase12() {
		try {
			CarParkKind kind = CarParkKind.STAFF;
			BigDecimal normalRate = new BigDecimal("5.1");
			BigDecimal reducedRate = null;
			ArrayList<Period> normalPeriods = new ArrayList<Period>();
			ArrayList<Period> reducedPeriods = new ArrayList<Period>();
			Period normalP = new Period(7, 10);
			Period reducedP = new Period(10,15);
			normalPeriods.add(normalP);
			reducedPeriods.add(reducedP);
			Rate rate = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
			assertNotNull(rate);
		}catch(IllegalArgumentException expected){	
		}
		
	}
	@Test
	public void testCase13() {
		try {
			CarParkKind kind = CarParkKind.STAFF;
			BigDecimal normalRate = new BigDecimal("5.1");
			BigDecimal reducedRate = new BigDecimal("3.1");
			ArrayList<Period> normalPeriods = new ArrayList<Period>();
			ArrayList<Period> reducedPeriods = new ArrayList<Period>();
			Period normalP = new Period(7, 10);
			Period reducedP = new Period(10,15);
//			normalPeriods.add(normalP);
			reducedPeriods.add(reducedP);
			Rate rate = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
			assertNotNull(rate);
		}catch(IllegalArgumentException expected){	
		}
	}
	@Test
	public void testCase14() {
		try {
			CarParkKind kind = CarParkKind.STAFF;
			BigDecimal normalRate = new BigDecimal("5.1");
			BigDecimal reducedRate = new BigDecimal("3.1");
			ArrayList<Period> normalPeriods = new ArrayList<Period>();
			ArrayList<Period> reducedPeriods = new ArrayList<Period>();
			Period normalP = new Period(7, 10);
			Period reducedP = new Period(10,15);
			normalPeriods.add(normalP);
//			reducedPeriods.add(reducedP);
			Rate rate = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
			assertNotNull(rate);
		}catch(IllegalArgumentException expected){	
		}
	}
	@Test
	public void testCase15() {
		CarParkKind kind = CarParkKind.STAFF;
		BigDecimal normalRate = new BigDecimal("5");
		BigDecimal reducedRate = new BigDecimal("3");
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		Period normalP = new Period(7, 10);
		Period reducedP = new Period(10,15);
		normalPeriods.add(normalP);
		reducedPeriods.add(reducedP);
		Rate rate = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
		
		int start = 8;
		int end = 12;
		Period stayTimes = new Period(start, end);
		BigDecimal cost = new BigDecimal(0);
		cost = rate.calculate(stayTimes);
		assertEquals(cost, new BigDecimal("16"));
	}
	@Test
	public void testCase16() {
		CarParkKind kind = CarParkKind.STAFF;
		BigDecimal normalRate = new BigDecimal("5");
		BigDecimal reducedRate = new BigDecimal("3");
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		Period normalP = new Period(7, 10);
		Period reducedP = new Period(10,15);
		normalPeriods.add(normalP);
		reducedPeriods.add(reducedP);
		Rate rate = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
		
		int start = 1;
		int end = 24;
		Period stayTimes = new Period(start, end);
		BigDecimal cost = new BigDecimal("0");
		cost = rate.calculate(stayTimes);
		assertEquals(cost, new BigDecimal("16"));
		
	}
	@Test
	public void testCase17() {
		try {
		CarParkKind kind = CarParkKind.STAFF;
		BigDecimal normalRate = new BigDecimal("5.1");
		BigDecimal reducedRate = new BigDecimal("3.1");
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		Period normalP = new Period(7, 10);
		Period reducedP = new Period(10,15);
		normalPeriods.add(normalP);
		reducedPeriods.add(reducedP);
		Rate rate = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);

		int start = 0;
		int end = 0;
		Period stayTimes = new Period(start, end);
		BigDecimal cost = rate.calculate(stayTimes);
		assertEquals(cost, 0);
		}catch(IllegalArgumentException expected){	
		}
	}
	@Test
	public void testCase18() {
		try {
			CarParkKind kind = CarParkKind.STAFF;
			BigDecimal normalRate = new BigDecimal("5.1");
			BigDecimal reducedRate = new BigDecimal("3.1");
			ArrayList<Period> normalPeriods = new ArrayList<Period>();
			ArrayList<Period> reducedPeriods = new ArrayList<Period>();
			Period normalP = new Period(7, 10);
			Period reducedP = new Period(10,15);
			normalPeriods.add(normalP);
			reducedPeriods.add(reducedP);
			Rate rate = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
			
			int start = 16;
			int end = 26;
			Period stayTimes = new Period(start, end);
			BigDecimal cost = new BigDecimal("0");
			cost = rate.calculate(stayTimes);
			assertEquals(cost, new BigDecimal("0"));
		}catch(IllegalArgumentException expected){	
		}
		
	}

	
}
