<script setup lang="ts">
    import { onMounted, ref } from 'vue'

    const canvasRef = ref<HTMLCanvasElement | null>(null)

    interface Particle {
        x: number
        y: number
        weight: number
    }

    const outerParticles: Particle[] = []
    const innerParticles: Particle[] = []

    function heart(t: number) {
        let x = 16 * Math.pow(Math.sin(t), 3)
        let y =
            13 * Math.cos(t) -
            5 * Math.cos(2 * t) -
            2 * Math.cos(3 * t) -
            Math.cos(4 * t)
        if (y < 0) y *= 0.75
        return { x, y }
    }

    onMounted(() => {
        const canvas = canvasRef.value!
        const ctx = canvas.getContext('2d')!

        canvas.width = window.innerWidth
        canvas.height = window.innerHeight

        // 外层心（大、稳定）
        for (let i = 0; i < 6500; i++) {
            const t = Math.random() * Math.PI * 2
            const { x, y } = heart(t)
            const spread = Math.random() ** 0.8
            outerParticles.push({ x: x * spread, y: y * spread, weight: Math.random() })
        }

        // 内层心（小、活跃）
        for (let i = 0; i < 4000; i++) {
            const t = Math.random() * Math.PI * 5
            const { x, y } = heart(t)
            const spread = Math.random() ** 0.35 * 0.82
            innerParticles.push({ x: x * spread, y: y * spread, weight: Math.random() })
        }

        let time = 0

        function draw() {
            ctx.clearRect(0, 0, canvas.width, canvas.height)
            ctx.save()
            ctx.translate(canvas.width / 2, canvas.height / 2)

            const beat = Math.sin(time)

            // 外层心方向与内层相反
            const outerPulse = -beat * 0.04
            const innerPulse = beat * 0.08
            const innerScale = 1 + beat * 0.06

            // ---------- 外层心 ----------
            for (const p of outerParticles) {
                // 膨胀时粒子稀疏，收缩时密集
                const densityFactor = 1 - 0.6 * Math.max(0, -beat)
                const k = 1 + outerPulse * p.weight * densityFactor

                // 随机透明度增强稀疏感
                const alpha = 0.35 + 0.25 * Math.random() * (1 - Math.max(0, beat))
                ctx.fillStyle = `rgba(255,120,150,${alpha})`

                ctx.fillRect(p.x * k * 12, -p.y * k * 12, 1.4, 1.4)
            }

            // ---------- 内层心 ----------
            ctx.save()
            ctx.scale(innerScale, innerScale)
            for (const p of innerParticles) {
                const k = 1 + innerPulse * p.weight
                ctx.fillStyle = 'rgba(255,150,180,0.9)'
                ctx.fillRect(p.x * k * 12, -p.y * k * 12, 1.6, 1.6)
            }
            ctx.restore()
            ctx.restore()

            time += 0.045
            requestAnimationFrame(draw)
        }

        draw()
    })
</script>

<template>
  <canvas ref="canvasRef"></canvas>
</template>

<style scoped>
  canvas {
    display: block;
    background: black;
  }
</style>
