
<div align=center>
  <img width=200 src="./doc/kekkai.png"  alt="image"/>
  <h1 align="center">Kekkai</h1> 
</div>

## Notice

#### **If there is no danmakucore or mirror,there is no kekkai,remember to show the best respect to TeamNightclipse's staff when using!**

## What's this?

It's a java lib for 1.12.2 Touhou Danmaku Developer



Kekkai will offer you some class or static method to execute the DanmakuCore or register a item/spellcard...

### How to use

1. Install **Minecraft** and **Forge(1.12.2)**
2. Download this mod from the repo
3. Put them on **mods** directory
4. Launch Game and Enjoy

## Develop with Kekkai

```groovy
repositories {
    maven {
        name 'TGS-Kekkai Github Package'
        url 'https://maven.pkg.github.com/TeamGensouSpark/kekkai'
        credentials {
            //you can use your Github account here too......
            username = "H2Sxxa"
            password = "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" //the token is read Github Package only
        }
    }
}

dependencies {
    implementation 'io.github.teamgensouspark.kekkai:kekkai:1.0-rc3' //change version yourself
}
```

## Credits

https://github.com/TeamNightclipse/DanmakuCore

https://github.com/TeamNightclipse/Mirror

https://github.com/TeamGensouSpark/LunarCapitalFramework