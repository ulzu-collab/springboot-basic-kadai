package com.example.samuraitravel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

// @Entity エンティティとして機能させる。
// @Table 対応するテーブル名を指定する。
// @Data ゲッターとセッターを自動生成する。

@Entity
@Table(name = "roles")
@Data
public class Role {
	
	// @Columm 対応するカラム名を指定する。
	// @Id フィールドを主キーに指定。@GeneratedValue(strategy = GenerationType.IDENTITY) データの作成と更新時にidの値を自動採番する。
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
}
